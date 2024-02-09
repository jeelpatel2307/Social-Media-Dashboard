class User:
    def __init__(self, username, email):
        self.username = username
        self.email = email
        self.posts = []

    def create_post(self, content):
        post = Post(content)
        self.posts.append(post)

    def display_posts(self):
        print(f"Posts by {self.username}:")
        for idx, post in enumerate(self.posts, start=1):
            print(f"Post {idx}: {post.content}")


class Post:
    def __init__(self, content):
        self.content = content


class SocialMediaDashboard:
    def __init__(self):
        self.users = []

    def create_user(self, username, email):
        user = User(username, email)
        self.users.append(user)
        print(f"User '{username}' created successfully.")

    def display_users(self):
        print("Registered Users:")
        for user in self.users:
            print(f"Username: {user.username}, Email: {user.email}")

    def create_post(self, username, content):
        for user in self.users:
            if user.username == username:
                user.create_post(content)
                print(f"Post created successfully by {username}.")
                return
        print(f"Error: User '{username}' not found.")

    def display_posts(self, username):
        for user in self.users:
            if user.username == username:
                user.display_posts()
                return
        print(f"Error: User '{username}' not found.")


def main():
    dashboard = SocialMediaDashboard()

    # Create users
    dashboard.create_user("Alice", "alice@example.com")
    dashboard.create_user("Bob", "bob@example.com")

    # Display registered users
    dashboard.display_users()

    # Create posts
    dashboard.create_post("Alice", "Hello, world!")
    dashboard.create_post("Bob", "Python is awesome!")

    # Display posts
    dashboard.display_posts("Alice")
    dashboard.display_posts("Bob")


if __name__ == "__main__":
    main()
