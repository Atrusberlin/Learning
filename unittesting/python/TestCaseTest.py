from WasRun import WasRun
from TestCase import *

class TestCaseTest(TestCase):
        
    def testTemplateMethod(self):
        test= WasRun("testMethod")
        test.run()
        #print(self.test.log)
        assert("setUp testMethod tearDown " == test.log)

    def testResult(self):
        test= WasRun("testMethod")
        result= test.run()
        print(result.summary())
        assert("1 run, 0 failed" == result.summary())

    def testFailedResult(self):
        test= WasRun("testBrokenMethod")
        result= test.run()
        assert("1 run, 1 failed", result.summary())

    def testFailedResultFormatting(self):
        result= TestResult()
        result.testStarted()
        result.testFailed()
        assert("1 run, 1 failed" == result.summary())

TestCaseTest("testFailedResultFormatting").run()
print("Test successful")
