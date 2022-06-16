class Human
   def initialize(name)
    @name = name
   end
    def getName
        @name
    end
    def setName(name)
        @name = name
    end 
end
ob = Human.new("Albert")
puts (ob.getName)
ob.setName("Hasan")
puts (ob.getName)