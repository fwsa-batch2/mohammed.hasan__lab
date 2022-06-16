class Person
  def starts
    private_method
  end

  def public_method
    puts "This is a public method"
  end

  protected

  def protected_method
    puts "This is a protected method"
  end

  private

  def private_method
    puts "Private method"
  end
end

class Sudo < Person
  def method_4
    p "Public Method of Sudo Class"
    self.public_method
    self.protected_method
    private_method   # cannot access as self.private_method
  end
end

ob = Person.new
ob2 = Person.new
# For private modifier
ob.starts
# ob.protected_method       #This gives an error
# For protected modifier . Proctected methods can be called only after creating objects for class. Can be used in other classes also by creating objects
# ob.protected_method

sudo_obj = Sudo.new
sudo_obj.method_4
