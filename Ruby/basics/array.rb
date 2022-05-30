array = Array[1,2,3]
array[3] = 4
s = "a,b,c"
splitted_array = s.split(",")
puts "Array of \"3\" is #{array.index(3)}"
puts s.instance_of? String
puts "Splitted Array #{splitted_array}"
array.push("d")
puts array.instance_of? Array