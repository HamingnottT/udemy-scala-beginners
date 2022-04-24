
# Example 1:
def sum_of_n(n):
    if n == 0:
        return 0
    else:
        return n + sum_of_n(n - 1)


def main():
    print(f"Using recursive example 1: {sum_of_n(5)}")


if __name__ ==  '__main__':
    main()