# related to Scala recursion in Python is similar so seeing these examples in this language may help

# Example 1:
def sum_of_n(n):
    if n == 0:
        return 0
    else:
        return n + sum_of_n(n - 1)

# Example 2:
def grid_paths(n, m):
    if n == 1 or m == 1:
        return 1
    else:
        return grid_paths(n, m - 1) + grid_paths(n - 1, m)

# Example 3:
def count_partitions(n, m):
    if n == 0:
        return 1
    elif m == 0 or n < 0:
        return 0
    else:
        return count_partitions(n - m, m) + count_partitions(n, m - 1)

def main():
    print("\n")
    
    n = 5
    print(f"Using recursive example 1: sum({n}) = {sum_of_n(n)}")
    print("\n")
    
    n, m = 4, 4
    print(f"Example 2: a {n} x {m} grid has {grid_paths(n, m)} possible paths")
    print("\n")
    
    n, m = 9, 5
    print(f"Example 3: you can partition {n} objects {count_partitions(n, m)} ways using up to {m} parts")


if __name__ ==  '__main__':
    main()