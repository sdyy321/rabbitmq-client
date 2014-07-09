/*
 * (C) 2007-2012 Alibaba Group Holding Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.poplaris.rabbitmq.client.util;

import java.io.UnsupportedEncodingException;

/**
 * User: poplar
 * Date: 14-7-4 下午5:59
 */
public class StringUtils {
    /**
     * 检查字符串是否为<code>null</code>或空字符串<code>""</code>。
     * 
     * <pre>
     * StringUtil.isEmpty(null)      = true
     * StringUtil.isEmpty("")        = true
     * StringUtil.isEmpty(" ")       = false
     * StringUtil.isEmpty("bob")     = false
     * StringUtil.isEmpty("  bob  ") = false
     * </pre>
     * 
     * @param str
     *            要检查的字符串
     * 
     * @return 如果为空, 则返回<code>true</code>
     */
    public static boolean isEmpty(final String str) {
        return str == null || str.length() == 0;
    }


    /**
     * 检查字符串是否是空白：<code>null</code>、空字符串<code>""</code>或只有空白字符。
     * 
     * <pre>
     * StringUtil.isBlank(null)      = true
     * StringUtil.isBlank("")        = true
     * StringUtil.isBlank(" ")       = true
     * StringUtil.isBlank("bob")     = false
     * StringUtil.isBlank("  bob  ") = false
     * </pre>
     * 
     * @param str
     *            要检查的字符串
     * 
     * @return 如果为空白, 则返回<code>true</code>
     */
    public static boolean isBlank(final String str) {
        int length;

        if (str == null || (length = str.length()) == 0) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }


	public static String replace(String inString, String oldPattern, String newPattern) {
		if (!hasLength(inString) || !hasLength(oldPattern) || newPattern == null) {
			return inString;
		}
		StringBuilder sb = new StringBuilder();
		int pos = 0; // our position in the old string
		int index = inString.indexOf(oldPattern);
		// the index of an occurrence we've found, or -1
		int patLen = oldPattern.length();
		while (index >= 0) {
			sb.append(inString.substring(pos, index));
			sb.append(newPattern);
			pos = index + patLen;
			index = inString.indexOf(oldPattern, pos);
		}
		sb.append(inString.substring(pos));
		// remember to append any characters to the right of a match
		return sb.toString();
	}
	
	/**
	 * Check that the given CharSequence is neither <code>null</code> nor of length 0.
	 * Note: Will return <code>true</code> for a CharSequence that purely consists of whitespace.
	 * <p><pre>
	 * StringUtils.hasLength(null) = false
	 * StringUtils.hasLength("") = false
	 * StringUtils.hasLength(" ") = true
	 * StringUtils.hasLength("Hello") = true
	 * </pre>
	 * @param str the CharSequence to check (may be <code>null</code>)
	 * @return <code>true</code> if the CharSequence is not null and has length
	 */
	public static boolean hasLength(CharSequence str) {
		return (str != null && str.length() > 0);
	}
	
	/**
	 * Check that the given String is neither <code>null</code> nor of length 0.
	 * Note: Will return <code>true</code> for a String that purely consists of whitespace.
	 * @param str the String to check (may be <code>null</code>)
	 * @return <code>true</code> if the String is not null and has length
	 */
	public static boolean hasLength(String str) {
		return hasLength((CharSequence) str);
	}
	
	public static byte[] getUtf8Bytes(String str){
		if(hasLength(str)){
			try {
				return str.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// ignore
				
			}
		}
		return null;
	}


	public static String getStringFromUtf8Bytes(byte[] tmpArray) {
		if(tmpArray != null && tmpArray.length > 0){
			try {
				return new String(tmpArray,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// ignore
				
			}
		}
		return null;
	}


	public static boolean equals(String str1, String str2) {
		if(str1==null && str2 == null){
			return true;
		}
		if(str1 == null || str2 == null){
			return false;
		}
		return str1.equals(str2);
	}
}