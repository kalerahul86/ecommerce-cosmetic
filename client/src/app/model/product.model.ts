import { CosmeticMaster } from './cosmetic-master.model';

export class Product {
    
    public id: string;
    public code: string;
    public name: string;
    public description: string;
    public images: string [];
    public category: CosmeticMaster;
    public company: CosmeticMaster;
    public tags: String[];

    /**
     * Getter $id
     * @return {string}
     */
	public getId(): string {
		return this.id;
	}

    /**
     * Getter $code
     * @return {string}
     */
	public getCode(): string {
		return this.code;
	}

    /**
     * Getter $name
     * @return {string}
     */
	public getName(): string {
		return this.name;
	}

    /**
     * Getter $description
     * @return {string}
     */
	public getDescription(): string {
		return this.description;
	}

    /**
     * Getter $images
     * @return {string []}
     */
	public getImages(): string [] {
		return this.images;
	}

    /**
     * Getter $category
     * @return {CosmeticMaster}
     */
	public getCategory(): CosmeticMaster {
		return this.category;
	}

    /**
     * Getter $company
     * @return {CosmeticMaster}
     */
	public getCompany(): CosmeticMaster {
		return this.company;
	}

    /**
     * Getter $tags
     * @return {CosmeticMaster[]}
     */
	public getTags(): String[] {
		return this.tags;
	}

    /**
     * Setter $id
     * @param {string} value
     */
	public setId(id: string) {
		this.id = id;
	}

    /**
     * Setter $code
     * @param {string} value
     */
	public setCode(code: string) {
		this.code = code;
	}

    /**
     * Setter $name
     * @param {string} value
     */
	public setName(name: string) {
		this.name = name;
	}

    /**
     * Setter $description
     * @param {string} value
     */
	public setDescription(description: string) {
		this.description = description;
	}

    /**
     * Setter $images
     * @param {string []} value
     */
	public setImages(images: string []) {
		this.images = images;
	}

    /**
     * Setter $category
     * @param {CosmeticMaster} value
     */
	public setCategory(category: CosmeticMaster) {
		this.category = category;
	}

    /**
     * Setter $company
     * @param {CosmeticMaster} value
     */
	public setCompany(company: CosmeticMaster) {
		this.company = company;
	}

    /**
     * Setter $tags
     * @param {CosmeticMaster[]} value
     */
	public setTags(tags: String[]) {
		this.tags = tags;
	}
    
}