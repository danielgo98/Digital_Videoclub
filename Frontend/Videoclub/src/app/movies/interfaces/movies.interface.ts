export interface Movie {
  id:          number;
  title:       string;
  image:       string;
  releaseDate: Date;
  synopsis:    string;
  director:    string;
  trailer:     string;
  categories:  string[];
}
