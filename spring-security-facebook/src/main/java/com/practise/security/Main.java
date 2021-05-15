package com.practise.security;

public class Main {

        public static void main(String[] args) {

            String firstInput = "98896598";
            char secondInput = '8';
            int numbOfOcc = 3;
            int count = 0;
            boolean result = false;

            for(int i =0;i<firstInput.length();i++) {
                if(firstInput.charAt(i)==secondInput) {
                    count++;
                }
            }

            if(numbOfOcc == count) {
                result = true;
            }
            System.out.println(result);

        }

    }
