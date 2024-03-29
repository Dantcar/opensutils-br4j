/*
 *	Updated 2010-11-22 with updates from JSMin.java(2007-05-22)
 *	Copyright (c) 2010 Felipe Priuli
 *
 *	This file was added in the distribution of OpenSutils-Br4J, and will be modified 
 *	to meet the needs this project, this file within the project belongs to OpenSutils-Br4J
 *  with the GNU Lesser General Public License
 *	This file is part of OpenSutils-Br4J.
 *
 *	OpenSutils-Br4J is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU Lesser General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, any later version.
 *
 *	OpenSutils-Br4J is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU Lesser General Public License for more details.
 *
 *	You should have received a copy of the GNU Lesser General Public License
 *	along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 *
 * JSMin.java 2006-02-13
 * 
 * Updated 2007-08-20 with updates from jsmin.c (2007-05-22)
 * 
 * Copyright (c) 2006 John Reilly (www.inconspicuous.org)
 * 
 * This work is a translation from C to Java of jsmin.c published by
 * Douglas Crockford.  Permission is hereby granted to use the Java 
 * version under the same conditions as the jsmin.c on which it is
 * based.  
 * 
 * jsmin.c 2003-04-21
 * 
 * Copyright (c) 2002 Douglas Crockford (www.crockford.com)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * The Software shall be used for Good, not Evil.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
*/
package org.opensutils.web.javascript;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
/**
 * <code>JSMin</code> class is a roller(compactor) javascript, for use in java.
 * @author Felipe Priuli 2010/11/22
 * @author John Reilly 2007-08-20
 * @author Douglas Crockford 2002
 * @version 0.2 (version of OpenSutils-Br4J)
 */
public class JSMin implements Minimizer{
	private static final int EOF = -1;

	private PushbackInputStream in;
	private OutputStream out;

	private int theA;
	private int theB;
	
	public JSMin() {
	}
	
	public JSMin(InputStream in, OutputStream out) {
		this.in = new PushbackInputStream(in);
		this.out = out;
	}
	
	/**
	 * isAlphanum -- return true if the character is a letter, digit,
	 * underscore, dollar sign, or non-ASCII character.
	 */
	static boolean isAlphanum(int c) {
		return ( (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || 
				 (c >= 'A' && c <= 'Z') || c == '_' || c == '$' || c == '\\' || 
				 c > 126);
	}

	/**
	 * get -- return the next character from stdin. Watch out for lookahead. If
	 * the character is a control character, translate it to a space or
	 * linefeed.
	 */
	private int get() throws IOException {
		int c = in.read();

		if (c >= ' ' || c == '\n' || c == EOF) {
			return c;
		}

		if (c == '\r') {
			return '\n';
		}
		
		return ' ';
	}

	
	
	/**
	 * Get the next character without getting it.
	 */
	private int peek() throws IOException {
		int lookaheadChar = in.read();
		in.unread(lookaheadChar);
		return lookaheadChar;
	}

	/**
	 * next -- get the next character, excluding comments. peek() is used to see
	 * if a '/' is followed by a '/' or '*'.
	 */
	private int next() throws IOException, UnterminatedCommentException {
		int c = get();
		if (c == '/') {
			switch (peek()) {
			case '/':
				for (;;) {
					c = get();
					if (c <= '\n') {
						return c;
					}
				}

			case '*':
				get();
				for (;;) {
					switch (get()) {
					case '*':
						if (peek() == '/') {
							get();
							return ' ';
						}
						break;
					case EOF:
						throw new UnterminatedCommentException();
					}
				}

			default:
				return c;
			}

		}
		return c;
	}

	/**
	 * action -- do something! What you do is determined by the argument: 1
	 * Output A. Copy B to A. Get the next B. 2 Copy B to A. Get the next B.
	 * (Delete A). 3 Get the next B. (Delete B). action treats a string as a
	 * single character. Wow! action recognizes a regular expression if it is
	 * preceded by ( or , or =.
	 */

	private void action(int d) throws IOException, UnterminatedRegExpLiteralException,
			UnterminatedCommentException, UnterminatedStringLiteralException {
		switch (d) {
		case 1:
			out.write(theA);
		case 2:
			theA = theB;

			if (theA == '\'' || theA == '"') {
				for (;;) {
					out.write(theA);
					theA = get();
					if (theA == theB) {
						break;
					}
					if (theA <= '\n') {
						throw new UnterminatedStringLiteralException();
					}
					if (theA == '\\') {
						out.write(theA);
						theA = get();
					}
				}
			}
			
		case 3:
			theB = next();
			if (theB == '/' && (theA == '(' || theA == ',' || theA == '=' ||
                    			theA == ':' || theA == '[' || theA == '!' || 
                    			theA == '&' || theA == '|' || theA == '?' || 
                    			theA == '{' || theA == '}' || theA == ';' || 
                    			theA == '\n')) {
				out.write(theA);
				out.write(theB);
				for (;;) {
					theA = get();
					if (theA == '/') {
						break;
					} else if (theA == '\\') {
						out.write(theA);
						theA = get();
					} else if (theA <= '\n') {
						throw new UnterminatedRegExpLiteralException();
					}
					out.write(theA);
				}
				theB = next();
			}
		}
	}

	/**
	 * jsmin -- Copy the input to the output, deleting the characters which are
	 * insignificant to JavaScript. Comments will be removed. Tabs will be
	 * replaced with spaces. Carriage returns will be replaced with linefeeds.
	 * Most spaces and linefeeds will be removed.
	 */
	public void jsmin() throws IOException, UnterminatedRegExpLiteralException, UnterminatedCommentException, UnterminatedStringLiteralException{
		theA = '\n';
		action(3);
		while (theA != EOF) {
			switch (theA) {
			case ' ':
				if (isAlphanum(theB)) {
					action(1);
				} else {
					action(2);
				}
				break;
			case '\n':
				switch (theB) {
				case '{':
				case '[':
				case '(':
				case '+':
				case '-':
					action(1);
					break;
				case ' ':
					action(3);
					break;
				default:
					if (isAlphanum(theB)) {
						action(1);
					} else {
						action(2);
					}
				}
				break;
			default:
				switch (theB) {
				case ' ':
					if (isAlphanum(theA)) {
						action(1);
						break;
					}
					action(3);
					break;
				case '\n':
					switch (theA) {
					case '}':
					case ']':
					case ')':
					case '+':
					case '-':
					case '"':
					case '\'':
						action(1);
						break;
					default:
						if (isAlphanum(theA)) {
							action(1);
						} else {
							action(3);
						}
					}
					break;
				default:
					action(1);
					break;
				}
			}
		}
		out.flush();
	}

	private class UnterminatedCommentException extends Exception {
		private static final long serialVersionUID = 1L;
	}

	private class UnterminatedStringLiteralException extends Exception {
		private static final long serialVersionUID = 1L;
	}

	private class UnterminatedRegExpLiteralException extends Exception {
		private static final long serialVersionUID = 1L;
	}

	/**
	 * Pinching a JavaScript file, removing spaces, comments and changing names of variables in
	 * order to decrease the size of a JavaScript file
	 * @param in - The JavaScript File 
	 * @param out - The out of JavaScript minimized
	 * @throws IOException - If a problem to minimize the file.
	 * @author Felipe Priuli
	 */
	@Override
	public void compress(InputStream in, OutputStream out) throws IOException {
		this.in = new PushbackInputStream(in);
		this.out = out;
		this.theA = 0;
		this.theA = 0;
		
		try {
			this.jsmin();
		} catch (UnterminatedRegExpLiteralException e) {
			throw new IOException("Unterminated regexp Literal", e);
		} catch (UnterminatedCommentException e) {
			throw new IOException("Unterminated comment", e);
		} catch (UnterminatedStringLiteralException e) {
			throw new IOException("Unterminated StringLiteral", e);
		}finally{
			if(this.out != null)
				this.out.close();
			
		}
		
	}
	/**
	 * Pinching a JavaScript file, removing spaces, comments and changing names of variables in
	 * order to decrease the size of a JavaScript file
	 * @param in - The JavaScript File 
	 * @param out - The new JavaScript minimized File
	 * @throws IOException - If a problem to minimize the file.
	 * @author Felipe Priuli
	 */
	public void compress(File in, File out) throws IOException {
		this.in = new PushbackInputStream( new FileInputStream(in));
		this.out = new BufferedOutputStream(new FileOutputStream(out));
		
		try {
			this.jsmin();
		} catch (UnterminatedRegExpLiteralException e) {
			throw new IOException("Unterminated regexp Literal", e);
		} catch (UnterminatedCommentException e) {
			throw new IOException("Unterminated comment", e);
		} catch (UnterminatedStringLiteralException e) {
			throw new IOException("Unterminated StringLiteral", e);
		}finally{
			if(this.out != null)
				this.out.close();	
		}
	}

}
