#!/bin/sh
printf "abc.l:"
cat abc.l
printf "\n"
printf "abc\naabbcc\nabcabc" > test2
cat test2
printf "\n"
flex abc.l
gcc lex.yy.c -o abc -lfl
./abc < test2