class Dog
    def name(petName)
        @petName = petName
    end
    def sound
        puts "#{@petName} Barks"
    end
    def movesTo(destination)
        puts "#{@petName} goes to #{destination}"
    end
end
class Cat
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

    
    