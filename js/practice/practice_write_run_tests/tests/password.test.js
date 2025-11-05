const Password = require('../src/sut_versions/Correct'); // Adjust the path as necessary

describe('Password', () => {
    test('constructor should throw Exceptions for passwords without uppercase letter', () => {
        expect(() => new Password('invalid123!')).toThrow();
    });
});