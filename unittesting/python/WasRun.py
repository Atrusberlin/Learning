class TestCase:
    def __init__(self, name):
        self.name= name

    def run(self):
        method= getattr(self, self.name)
        method()

class WasRun(TestCase):
    def __init__(self, name):
        self.wasRun= None
        TestCase.__init__(self, name)

    def testMethod(self):
    #    print ("testMethod called")
        self.wasRun= 1

class TestCaseTest(TestCase):
    def testRunning(self):
        test= WasRun("testMethod")
        assert ( test.wasRun)
        test.run()
        #test.testMethod()
        assert (test.wasRun)

TestCaseTest("testRunning").run()
