begin
    number_array = [1,2,3,4,5,6,7]
    puts number_array['a']
rescue
    puts "there was an error"
else
    puts "Else block executed"
ensure
    puts "Ensure always runs"
end