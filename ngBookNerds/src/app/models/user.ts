import { Address } from "./address";
import { Book } from "./book";

export class User {
  id: number = 0;
  username: string = "";
  password: string = "";
  role: string = "";
  firstName: string = "";
  lastName: string = "";
  email: string = "";
  aboutMe: string = "";
  dateOfBirth: string = "";
  profileImageUrl: string = "";
  address: Address = new Address();
  favoriteBooks: Book[] = [];

  constructor(
    id: number = 0,
    username: string = "",
    password: string = "",
    role: string = "",
    firstName: string = "",
    lastName: string = "",
    email: string = "",
    aboutMe: string = "",
    dateOfBirth: string = "",
    profileImageUrl: string = "",
    address: Address = new Address(),
    favoriteBooks: Book[] = []
  ) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.aboutMe = aboutMe;
    this.dateOfBirth = dateOfBirth;
    this.profileImageUrl = profileImageUrl;
    this.address = address ? address : new Address();
    this.favoriteBooks = favoriteBooks ? favoriteBooks : [];
  }
}
