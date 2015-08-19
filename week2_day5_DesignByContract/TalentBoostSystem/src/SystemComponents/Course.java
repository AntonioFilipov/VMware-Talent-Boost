package SystemComponents;

/**
 * Contain the name and description for every course in TalentBoost
 * 
 * @author Antonio
 *
 *
 */
public class Course {

		private String name;
		private String description;

		/**
		 * 
		 * @param name
		 *            name of course
		 * @param description
		 *            description of course
		 * 
		 * */
		public Course(String name, String description) {
			this.setName(name);
			this.setDescription(description);
		}

		/**
		 * @return name of course
		 */
		public String getName() {
			return name;
		}

		/**
		 * set name of course
		 * 
		 * @param name
		 *            name of course
		 * @throws IllegalArgumentException
		 *             name is invalid
		 */
		private void setName(String name) {
			boolean isString = ValidationFunctions.stringValidation(name);
			if (!isString) {
				throw new IllegalArgumentException("Name cannot be empty or null");
			}
			this.name = name;
		}
		
		/**
		 * @return description of course
		 */
		public String getDescription() {
				return this.description;
		}

		/**
		 * set description of course
		 */
		public void setDescription(String description) {
			boolean isString = ValidationFunctions.stringValidation(description);
			if (!isString) {
				throw new IllegalArgumentException("Description cannot be empty or null");
			}
			this.description = description;
		}



}
