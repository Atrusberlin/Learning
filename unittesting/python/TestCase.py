class TestCase:
    def __init__(self, name):
        self.name= name

    def setUp(self):
        pass

    def run(self):
        result= TestResult()
        result.testStarted()
        self.setUp()
        try:
            method= getattr(self, self.name)
            method()
        except:
            result.testFailed()
        self.tearDown()
        return result

    def tearDown(self):
        pass

class TestResult:
    def __init__(self):
        self.runCount= 0
        self.errorCount= 0

    def testStarted(self):
        self.runCount= self.runCount + 1

    def testFailed(self):
            self.errorCount= self.errorCount + 1

    def summary(self):
        return "%d run, %d failed" % (self.runCount, self.errorCount)