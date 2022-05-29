puts "Hello World"
class ArithmeticOperations
    def sum(a,b)
        (a+b).to_s
    end
    def subtract(a,b)
        a-b
    end
    def multiply(a,b)
        a*b
    end
    def divide(a,b)
        a/b        
    end
    def mod(a,b)
        a%b
    end 
end
c = ArithmeticOperations.new
puts "Addition of 5 and 6 is : #{c.sum(5,6)}"
