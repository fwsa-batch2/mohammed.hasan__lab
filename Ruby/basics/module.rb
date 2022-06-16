module Actionable
    def swim
        puts "Parent Swimming"
    end
    def run
        puts " Parent Running"
    end
    def Actionable.swimming
        puts "Static method Swimming"
    end

    class HasanLab
        def hasan
            puts "Inside a class"
        end
    end
end

# TO call a method wihtout its object or including
Class.new.extend(Actionable).swim

# Both are same
# Actionable::swimming
# Actionable.swimming

# Calling a class
# ob = Actionable::HasanLab.new
# ob.hasan
