class Dog
    @@same_for_all_instances
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

ob = Dog.new
ob.name("Blacky")
ob.sound
ob.movesTo("Freshworks")

    
    