# 1. Two Sum
# https://leetcode.com/problems/two-sum

# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)
    complement_indices = {}
    (0..nums.size - 1).each do |i|
        if complement_indices.key?(target - nums[i])
            return [i, complement_indices[target - nums[i]]]
        else
            complement_indices[nums[i]] = i
        end
    end
end