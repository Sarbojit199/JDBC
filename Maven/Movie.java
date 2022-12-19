package com.sarbopojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity									//class is an entity and table creation
@Table(name="Movie")
public class Movie {
		@Id
		private int id;
		@Column
		private String movieName;
		@Column
		private String actor;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getMovieName() {
			return movieName;
		}
		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}
		public String getActor() {
			return actor;
		}
		public void setActor(String actor) {
			this.actor = actor;
		}
		public Movie() {
			super();
		}
		public Movie(int id, String movieName, String actor) {
			super();
			this.id = id;
			this.movieName = movieName;
			this.actor = actor;
		}
		@Override
		public String toString() {
			return "Movie [id=" + id + ", movieName=" + movieName + ", actor=" + actor + "]";
		}
		
		
}
