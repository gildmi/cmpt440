#!/bin/sh
javac RegEx.java
printf "0\n1\n10\n11\n100\n101\n111\n1000" > numbers
java RegexFilter '^(0|1(01*0)*1)*$' < numbers