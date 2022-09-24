import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Book } from "src/app/models/book";
import { User } from "src/app/models/user";
import { AuthService } from "src/app/services/auth.service";
import { BookService } from "src/app/services/book.service";
import { ProfileService } from "src/app/services/profile.service";

@Component({
  selector: "app-profile",
  templateUrl: "./profile.component.html",
  styleUrls: ["./profile.component.css"],
})
export class ProfileComponent implements OnInit {
  loggedInUser: User = new User();
  books: Book[] = [];
  editUser: User | null = null;

  constructor(
    private auth: AuthService,
    private bookSvc: BookService,
    private profileSvc: ProfileService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.setLoggedInUser();
  }

  setLoggedInUser() {
    this.auth.getLoggedInUser().subscribe({
      next: (user) => {
        this.loggedInUser = user;
        this.loadBooks();
      },
      error: (err) => {
        console.error(
          "ProfileComponent.setLoggedInUser(): Error loading profile user"
        );
        console.error(err);
        this.router.navigateByUrl('home');
      },
    });
  }

  loadBooks() {
    this.bookSvc.getAllBooks().subscribe({
      next: (books) => {
        this.books = books;
        for (const book of this.books) {
          if (this.isFavorite(book)) {
            book.favorited = true;
          }
        }
      },
      error: (err) => {
        console.error("ProfileComponent.loadBooks(): Error loading books");
        console.error(err);
      },
    });
  }

  isFavorite(book: Book): boolean {
    for (const fav of this.loggedInUser.favoriteBooks) {
      if (book.id === fav.id) {
        return true;
      }
    }
    return false;
  }

  setEditUser() {
    this.editUser = Object.assign({}, this.loggedInUser);
    console.log("setEditUser:");
    console.log(this.editUser);
  }

  updateProfile() {
    if (this.editUser) {
      this.editUser.favoriteBooks = [];
      for (const book of this.books) {
        if (book.favorited) {
          this.editUser.favoriteBooks.push(book);
        }
      }
      console.log(this.editUser);

      this.profileSvc.updateProfile(this.editUser).subscribe({
        next: (updatedUser) => {
          this.loggedInUser = updatedUser;
          this.editUser = null;
        },
        error: (fail) => {
          console.error('ProfileComponent.updateProfile(): error updating user:');
          console.error(this.editUser);
          console.error(fail);
        }
      });
    }

  }
}
