### Mariya Al Nasrala

##  Report – SSNHelper and SwedishSocialSecurityNumber

In this assignment I tested two dependent classes: `SwedishSocialSecurityNumber` and `SSNHelper`.  
The goal is to ensure that each class is tested independently, so that a failing test clearly indicates which class contains a defect.

### Testing

- `SSNHelper` is tested directly using unit tests without mocks.
- `SwedishSocialSecurityNumber` is tested using a mocked `SSNHelper` to isolate its internal logic.
- Mockito is used to control the behavior of the dependency and prevent helper bugs from affecting constructor and accessor tests.
- Each test contains a single assertion unless additional verification is required.
- For each known buggy implementation, a specific test is included to demonstrate that the bug is detected.

### Bug Coverage

The tables above show the relationship between tests and implementations:
- ✅ indicates that the test passes for that implementation.
- ❌ indicates that the test correctly fails due to a known bug.
- Each buggy implementation is caught by at least one test.
- Correct implementations achieve 100% coverage.

## SSNHelper – Test Coverage Matrix

| Testname            | Correct | Allow Month 0 | Wrong Length | Incorrect Format | Day up to 30 | Messy Luhn |
|---------------------|---------|---------------|--------------|------------------|--------------|------------|
| Invalid Length      | ✅      | ✅            | ❌           | ✅               | ✅           | ✅         |
| Invalid month       | ✅      | ❌            | ✅           | ✅               | ✅           | ✅         |
| Valid day           | ✅      | ✅            | ✅           | ✅               | ❌           | ✅         |
| Invalid format      | ✅      | ✅            | ✅           | ❌               | ✅           | ✅         |
| Valid luhnsCorrect  | ✅      | ✅            | ✅           | ✅               | ✅           | ❌         |
| Valid month         | ✅      | ✅            | ✅           | ✅               | ✅           | ✅         |
| Coverage            | 100%    | 100%          | 100%         | 100%             | 100%         | 100%      |


## SwedishSocialSecurityNumber – Test Coverage Matrix

| Testname                                      | Correct | Wrong Length | Wrong Year | No Trim | No Luhn |
|----------------------------------------------|---------|--------------|------------|---------|---------|
| constructorShouldThrowExceptionWhenLengthInvalid | ✅      | ❌           | ✅         | ✅      | ✅      |
| constructorShouldThrowExceptionWhenFormatInvalid | ✅      | ✅           | ✅         | ✅      | ✅      |
| constructorShouldThrowExceptionWhenMonthInvalid  | ✅      | ✅           | ✅         | ✅      | ✅      |
| constructorShouldThrowExceptionWhenDayInvalid    | ✅      | ✅           | ✅         | ✅      | ✅      |
| constructorShouldThrowExceptionWhenLuhnInvalid   | ✅      | ✅           | ✅         | ✅      | ❌      |
| constructorShouldTrimString                      | ✅      | ✅           | ✅         | ❌      | ✅      |
| getYearShouldReturnFirstTwoDigits                | ✅      | ✅           | ❌         | ✅      | ✅      |
| getSerialNumberShouldReturnLastFourDigits        | ✅      | ✅           | ✅         | ✅      | ✅      |
| Coverage                                         | 100%    | 100%         | 100%       | 100%    | 100%    |
