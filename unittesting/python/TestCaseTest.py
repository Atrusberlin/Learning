from WasRun import WasRun
from TestCase import TestCase

class TestCaseTest(TestCase):
        
    def testTemplateMethod(self):
        test= WasRun("testMethod")
        test.run()
        #print(self.test.log)
        assert("setUp testMethod tearDown " == test.log)
        

TestCaseTest("testTemplateMethod").run()
print("Test successful")
