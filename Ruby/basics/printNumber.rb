num = gets.chomp().to_i;
randomNumber = rand 100;
puts "Random number is #{randomNumber}"
puts "Number you entered is #{num}"

# TO check type of variable
print "Is it a string ? #{num.instance_of? String}"
