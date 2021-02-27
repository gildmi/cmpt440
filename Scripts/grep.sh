#!/bin/sh
printf "fred\nbarney\nwilma\nbetty" > names
printf "\nNames:\n"
cat names
printf "0\n1\n10\n11\n100\n101\n111\n1000" > numbers
printf "\nNumbers:\n"
cat numbers
echo "egrep 'a' names"
egrep 'a' names
echo "egrep 'a.*y' names"
egrep 'a.*y' names
echo "egrep '.(..)*' names"
egrep '.(..)*' names
echo "egrep '^.(..)*$' names"
egrep '^.(..)*$' names
echo "egrep '^(0|1(01*0)*1)*$' numbers"
egrep '^(0|1(01*0)*1)*$' numbers