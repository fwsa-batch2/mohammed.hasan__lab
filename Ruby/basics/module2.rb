# This runs the module.rb and then runs this file
require_relative "./module.rb"

class Animals
    # Includes checks first in this class if fn exists; then chekcs module
    # include Actionable
    # prepend checks first in parent module; if not found then checks in this class
    prepend Actionable
    def initialize
        self.run
    end
    def run
        puts "This class running"
    end
end

cat = Animals.new
# puts cat.instance_variables