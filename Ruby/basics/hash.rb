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

# Passing hash as an argument
class Employee
   attr_accessor :name, :age, :occupation
   def initialize(name, options)
      self.name = name
      self.occupation = options[:occupation]
      self.age = options[:age]
   end
end
employee = Employee.new("Don", age: 5, occupation: "Business") # Can add {} bracket or not, it automatically knows 
p employee