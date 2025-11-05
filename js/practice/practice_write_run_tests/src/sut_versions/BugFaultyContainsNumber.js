class Password {
  constructor(pw) {
    const trimmedPW = pw.trim(); // Ta bort mellanslag i början och slutet

    if (this.isTooShort(trimmedPW)) {
      throw new Error("För kort lösenord");
    }

    if (!this.containsNumber(trimmedPW)) {
      throw new Error("Innehåller inget nummer");
    }

    this.passwordHash = this.simpleHash(trimmedPW);
  }

  simpleHash(input) {
    let hash = 7;
    for (let i = 0; i < input.length; i++) {
      hash = hash * 31 + input.charCodeAt(i);
    }
    return hash;
  }

  isTooShort(pw) {
    return pw.length < 12;
  }

  containsNumber(text) {
    return true
  }

  getPasswordHash() {
    return this.passwordHash;
  }

  isPasswordSame(other) {
    return this.passwordHash === other.getPasswordHash();
  }
}