class Dog
    @@same_for_all_instances = true
    @instance_var
    attr_accessor :pet_name     # Combo of attr_reader and attr_writer
    
    def self.class_method
        puts "This is a class method"
    end 
    def name(pet_name)
        @pet_name = pet_name
    end
    def sound
        puts "#{@pet_name} Barks"
    end
    def movesTo(destination)
        puts "#{@pet_name} goes to #{destination}"
    end
end
class Cat
    @@same_for_all_instances
    @instance_var
    def sound
        puts "Cat Meows"
    end
    def movesTo(destination)
        puts "Cat goes to #{destination} to drink milk"
    end
end

# Dog.class_method
ob = Dog.new
ob.name("Blacky")
puts ob.pet_name = "Whity"
ob.sound
ob.movesTo("Freshworks")
puts ob.instance_variables
# Gets the class variable
puts "Instance variable #{Dog.class_variable_get(:@@same_for_all_instances)}"

    
    