from TestCase import TestCase

class WasRun(TestCase):
    def __init__(self, name):
        TestCase.__init__(self, name)

    def testMethod(self):
        self.log= self.log + "testMethod "

    def setUp(self):
        self.wasRun= None
        self.log= "setUp "

    def tearDown(self):
        self.log= self.log + "tearDown "

    def testBrokenMethod(self):
        raise Exception

