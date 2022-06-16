todos = [
    ["Send invoice", "money"],
    ["Clean room", "organize"],
    ["Pay rent", "money"],
    ["Arrange books", "organize"],
    ["Pay taxes", "money"],
    ["Buy groceries", "food"]
  ]
hash = Hash.new();

for i in todos
       unless(hash[i[1].to_sym])
        hash[i[1].to_sym] = Array.new
    end
    hash[i[1].to_sym].push(i[0])
end
puts "Hash #{hash}"