file = File.open("C:\\Users\\hasan\\mohammed.hasan__lab\\Ruby\\basics\\dummy.txt")
file_array = file.readlines
puts file_array[0]
file.close

# Automatically closes file object
File.open("C:\\Users\\hasan\\mohammed.hasan__lab\\Ruby\\basics\\dummy.txt") do |f|
    puts "Inside block"
    array = f.readlines
    puts array
end
