# 1st Method
# def block_code(&block)
#     puts "Inside method"
#     block.call(5,10)
#     puts "Again Inside method"

# end

# 2nd Method using yield
def block_code
    puts "Inside method"
    yield(5,10)
    puts "Again Inside method"

end

block_code do |a,b|
puts "Inside block"
puts "First param #{a}"
puts "Second param #{b}"
end