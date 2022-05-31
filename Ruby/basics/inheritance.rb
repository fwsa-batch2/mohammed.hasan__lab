class Vehicle
    attr_accessor :name, :litres_consumed, :odometer

def sound
    puts "Beep Beep"
end
def mileage
    @odometer / @litres_consumed
end
end

class Bike < Vehicle
    def sound
        # calls super class method and then runs this method
        super
        puts "Drrr drr"
    end
def gear
    puts "Gear"
end
end

class Car < Vehicle

end

# Child class does not have all instance variables created. It gets created only when a method uses it or contains it

bike = Bike.new
bike.name = "Bike"
# bike.litres_consumed = 500
# puts bike.instance_variables
bike.gear
bike.sound