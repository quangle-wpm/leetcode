# 2. Add Two Numbers
# https://leetcode.com/problems/add-two-numbers/

# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val = 0, _next = nil)
#         @val = val
#         @next = _next
#     end
# end
# @param {ListNode} l1
# @param {ListNode} l2
# @return {ListNode}
def add_two_numbers(l1, l2)
    if l1.nil? && l2.nil?
        return nil
    end

    l3 = ListNode.new(0)
    result = l3
    carry = 0

    while l1 || l2
        sum = (l1&.val || 0) + (l2&.val || 0) + carry
        carry = sum / 10

        l3.next = ListNode.new(sum % 10)
        l3 = l3.next

        if l1 then l1 = l1.next end
        if l2 then l2 = l2.next end
    end

    if carry > 0
        l3.next = ListNode.new(carry)
    end

    return result.next
end