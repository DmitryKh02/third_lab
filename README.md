My program calculates the speed of performing an operation on two lists: Linked and Array.
Operations were considered: add, get, delete, sort and clear. In the first three of them, options with the beginning of the list, with the middle and with the end were considered.
The number of items in the list is determined by the array, which you can change, but it is not recommended to set values more than 100,000!!!
The nanoTime() function was chosen as the time counting function because of its greater accuracy than currenttimemillis(), Instant and Duration. The execution time of the function was calculated in nanoseconds!!! (If that 1 millisecond = 1000000 nanoseconds)
