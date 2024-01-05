package entities;

public class Task {
  private int Id;
  private String description;
  private String dateOfCreation;
  private boolean completed;

  public Task(int Id, String description, String dateOfCreation, boolean completed) {
    this.Id = Id;
    this.description = description;
    this.dateOfCreation = dateOfCreation;
    this.completed = completed;

  }

  public int getId() {
    return Id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDateOfCreation() {
    return dateOfCreation;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
}

}
