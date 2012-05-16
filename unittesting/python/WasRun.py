from TestCase import TestCase

class WasRun(TestCase):
    def __init__(self, name):
        TestCase.__init__(self, name)

    def testMethod(self):
        print ("testMethod called")
        self.wasRun= 1

    def setUp(self):
        self.wasRun= None
        self.wasSetUp= 1

