def two_number_sum(array, target_sum):
    nums = {}
    for num in array:
        potential_match = target_sum - num
        if potential_match in nums:
            return [potential_match, num]
        else:
            nums[num] = True
    return []

# Example usage:
array = [3, 5, -4, 8, 11, 1, -1, 6]
target_sum = 10
print(two_number_sum(array, target_sum))  # Output: [11, -1] or [-1, 11]
