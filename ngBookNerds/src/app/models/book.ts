import { Author } from "./author";
import { User } from "./user";

export class Book {
  id: number = 0;
  title: string = '';
  coverImageUrl: string = '';
  addedBy: User = new User();
  author: Author = new Author();
  favorited: boolean = false;

  /**
   *
   */
  constructor(
    id: number = 0,
    title: string = '',
    coverImageUrl: string = '',
    addedBy: User = new User(),
    author: Author = new Author(),
    favorited: boolean = false
  ) {
    this.id = id;
    this.title = title;
    this.coverImageUrl = coverImageUrl;
    this.addedBy = addedBy ? addedBy : new User();
    this.author = author ? author : new Author();
    this.favorited = favorited;
  }
}
