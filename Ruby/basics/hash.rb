hash = { 
    "Name" => "Mohammed",
    2 => "Hasan",
    3 => "Riyas",
    4 => nil
 }
 hash.each do |key, value|
    puts "Key : #{key}   Value : #{value}"
 end    

 # Gives new copy with removed nil values
hash1 = hash.compact
puts hash1
 # Gives self copy with removed nil values
hash2 = hash.compact!
puts hash2