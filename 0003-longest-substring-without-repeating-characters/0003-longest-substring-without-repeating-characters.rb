# @param {String} s
# @return {Integer}
def length_of_longest_substring(s)
  	left = 0
	maxlength = 0

    characters = Set.new
	for right in (0...s.length)
		until characters.add?(s[right])
			characters.delete(s[left])
			left += 1
		end

		maxlength = [maxlength, characters.length].max
	end
	return maxlength
end