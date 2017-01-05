If "Matrix Multiplication (stack).c" is exectuted without changing the stack size, it will through a SIGSEGV error.

In order to not get that error, the stack size has to be enlarge to at least 24 Mbytes (1000 * 1000 * 64 = 8 Mbytes, if we use long long ints). This can be accomplished by typing "ulimit -s 24000" in a console.

