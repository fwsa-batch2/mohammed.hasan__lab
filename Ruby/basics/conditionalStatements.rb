# isMale = false;
# isTall = false;
# if isMale && isTall
#     puts "He is male and tall"
#     elsif isMale and !isTall
#         puts "He is short male"
#         elsif isTall && !isMale
#             puts "She is tall but not male"
# else
#     puts "She is short female"
# end   

#   for loops
# puts "Number traversing"
for a in 0...5
    puts a 
end

# array = ["Apple","Mango","Grapes"]
# puts "Array traversing"
# for i in array
#     puts i
# end
# i=0
# if(i < 5)
#     puts i
#     i+=1
# end

# Do-while loop
# i=0
# loop do
#     puts i
#     i+=1
#     break if i == 7
# end

# Retry loop
attempt_again = true
puts 'checking'
begin

  # This is the point where the control flow jumps
  p 'crash'
  puts "crashed"
  # retyr runs code till before raise
  raise 5/0
    rescue ZeroDivisionError
      if attempt_again
        attempt_again = false
        puts "Error"
    retry       
  end
end