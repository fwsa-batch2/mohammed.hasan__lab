require "singleton"

class Shopping
    include Singleton
end

puts Shopping.instance.object_id
puts Shopping.instance.object_id