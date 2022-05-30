hash = { 
    "Name" => "Mohammed",
    2 => "Hasan",
    3 => "Riyas",
    4 => nil
 }
 puts hash["Name"]
 puts hash[2]
 # Gives new copy with removed nil values
hash1 = hash.compact
puts hash1
 # Gives self copy with removed nil values
hash2 = hash.compact!
puts hash2