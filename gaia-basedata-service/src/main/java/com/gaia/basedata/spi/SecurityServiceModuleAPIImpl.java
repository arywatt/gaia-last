/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gaia.basedata.spi;

import com.gaia.security.entities.Permission;
import com.gaia.security.entities.PermissionCategory;
import com.gaia.security.entities.Role;
import com.gaia.security.spi.ISecurityServiceModuleAPI;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;


/**
 *
 * @author yeena
 */
public class SecurityServiceModuleAPIImpl implements ISecurityServiceModuleAPI {
    
    private static final String PERMISSION_CATEGORY_ID = "basedata";
   
    @Override
    public Collection<PermissionCategory> permissionCategories() {
        Collection<PermissionCategory> categories = new LinkedList<PermissionCategory>();
        categories.add(new PermissionCategory("basedata", "permission.category.basedata", "Données de base"));
        return categories;
    }

    @Override
    public Collection<Permission> permissions() {
        Collection<Permission> permissions = new LinkedList<Permission>();
        
//        permissions.add(new Permission(BaseDataPermissions.MANAGE,
//                "permission.basedata.manage", "Gérer toutes les données de base", PERMISSION_CATEGORY_ID));
//        
//        // permissions liées aux composantes de données de base
//        
//        //AlevelAppreciation
//        permissions.add(new Permission(BaseDataPermissions.ALEVEL_APPRECIATION_MANAGE,
//                "permission.basedata.alevelappreciation.manage", "Gérer les mentions de BAC", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.ALEVEL_APPRECIATION_ADD,
//                "permission.basedata.alevelappreciation.add", "Ajouter des mentions de BAC", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.ALEVEL_APPRECIATION_EDIT,
//                "permission.basedata.alevelappreciation.edit", "Modifier des mentions de BAC", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.ALEVEL_APPRECIATION_DELETE,
//                "permission.basedata.alevelappreciation.delete", "Supprimer des mentions de BAC", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.ALEVEL_APPRECIATION_LIST,
//                "permission.basedata.alevelappreciation.list", "Consulter la liste des mentions de BAC", PERMISSION_CATEGORY_ID));
//        
//        //AlevelField
//        permissions.add(new Permission(BaseDataPermissions.ALEVEL_FIELD_MANAGE,
//                "permission.basedata.alevelfield.manage", "Gérer les series de BAC", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.ALEVEL_FIELD_ADD,
//                "permission.basedata.alevelfield.add", "Ajouter des series de BAC", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.ALEVEL_FIELD_EDIT,
//                "permission.basedata.alevelfield.edit", "Modifier des series de BAC", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.ALEVEL_FIELD_DELETE,
//                "permission.basedata.alevelfield.delete", "Supprimer des series de BAC", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.ALEVEL_FIELD_LIST,
//                "permission.basedata.alevelfield.list", "Consulter la liste des series de BAC", PERMISSION_CATEGORY_ID));
//        
//        //Bank
//        permissions.add(new Permission(BaseDataPermissions.BANK_MANAGE,
//                "permission.basedata.bank.manage", "Gérer les banques", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.BANK_ADD,
//                "permission.basedata.bank.add", "Ajouter des banques", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.BANK_EDIT,
//                "permission.basedata.bank.edit", "Modifier des banques", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.BANK_DELETE,
//                "permission.basedata.bank.delete", "Supprimer des banques", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.BANK_LIST,
//                "permission.basedata.bank.list", "Consulter la liste des banques", PERMISSION_CATEGORY_ID));
//        //City
//        permissions.add(new Permission(BaseDataPermissions.CITY_MANAGE,
//                "permission.basedata.city.manage", "Gérer les villes", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.CITY_ADD,
//                "permission.basedata.city.add", "Ajouter des villes", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.CITY_EDIT,
//                "permission.basedata.city.edit", "Modifier des villes", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.CITY_DELETE,
//                "permission.basedata.city.delete", "Supprimer des villes", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.CITY_LIST,
//                "permission.basedata.city.list", "Consulter la liste des villes", PERMISSION_CATEGORY_ID));
//        
//        //Country
//        permissions.add(new Permission(BaseDataPermissions.COUNTRY_MANAGE,
//                "permission.basedata.country.manage", "Gérer les pays", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.COUNTRY_ADD,
//                "permission.basedata.country.add", "Ajouter des pays", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.COUNTRY_EDIT,
//                "permission.basedata.country.edit", "Modifier des pays", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.COUNTRY_DELETE,
//                "permission.basedata.country.delete", "Supprimer des pays", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.COUNTRY_LIST,
//                "permission.basedata.country.list", "Consulter la liste des pays", PERMISSION_CATEGORY_ID));
//        
//        //Fee
//        permissions.add(new Permission(BaseDataPermissions.FEE_MANAGE,
//                "permission.basedata.fee.manage", "Gérer les frais", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.FEE_ADD,
//                "permission.basedata.fee.add", "Ajouter des frais", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.FEE_EDIT,
//                "permission.basedata.fee.edit", "Modifier des frais", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.FEE_DELETE,
//                "permission.basedata.fee.delete", "Supprimer des frais", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.FEE_LIST,
//                "permission.basedata.fee.list", "Consulter la liste des frais", PERMISSION_CATEGORY_ID));
//        
//        //Gender
//        permissions.add(new Permission(BaseDataPermissions.GENDER_MANAGE,
//                "permission.basedata.gender.manage", "Gérer les genres", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.GENDER_ADD,
//                "permission.basedata.gender.add", "Ajouter des genres", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.GENDER_EDIT,
//                "permission.basedata.gender.edit", "Modifier des genres", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.GENDER_DELETE,
//                "permission.basedata.gender.delete", "Supprimer des genres", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.GENDER_LIST,
//                "permission.basedata.gender.list", "Consulter la liste des genres", PERMISSION_CATEGORY_ID));
//        
//        //MaritalStatus
//        permissions.add(new Permission(BaseDataPermissions.MARITAL_STATUS_MANAGE,
//                "permission.basedata.maritalstatus.manage", "Gérer les stituations matrimoniales", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.MARITAL_STATUS_ADD,
//                "permission.basedata.maritalstatus.add", "Ajouter des stituations matrimoniales", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.MARITAL_STATUS_EDIT,
//                "permission.basedata.maritalstatus.edit", "Modifier des stituations matrimoniales", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.MARITAL_STATUS_DELETE,
//                "permission.basedata.maritalstatus.delete", "Supprimer des stituations matrimoniales", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.MARITAL_STATUS_LIST,
//                "permission.basedata.maritalstatus.list", "Consulter la liste des stituations matrimoniales", PERMISSION_CATEGORY_ID));
//        
//        //Prefecture
//        permissions.add(new Permission(BaseDataPermissions.PREFECTURE_MANAGE,
//                "permission.basedata.prefecture.manage", "Gérer les prefectures", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.PREFECTURE_ADD,
//                "permission.basedata.prefecture.add", "Ajouter des prefectures", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.PREFECTURE_EDIT,
//                "permission.basedata.prefecture.edit", "Modifier des prefectures", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.PREFECTURE_DELETE,
//                "permission.basedata.prefecture.delete", "Supprimer des prefectures", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.PREFECTURE_LIST,
//                "permission.basedata.prefecture.list", "Consulter la liste des prefectures", PERMISSION_CATEGORY_ID));
//        
//        //Profession
//        permissions.add(new Permission(BaseDataPermissions.PROFESSION_MANAGE,
//                "permission.basedata.profession.manage", "Gérer les professions", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.PROFESSION_ADD,
//                "permission.basedata.profession.add", "Ajouter des professions", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.PROFESSION_EDIT,
//                "permission.basedata.profession.edit", "Modifier des professions", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.PROFESSION_DELETE,
//                "permission.basedata.profession.delete", "Supprimer des professions", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.PROFESSION_LIST,
//                "permission.basedata.profession.list", "Consulter la liste des professions", PERMISSION_CATEGORY_ID));
//        
//        //Qualification
//        permissions.add(new Permission(BaseDataPermissions.QUALIFICATION_MANAGE,
//                "permission.basedata.qualification.manage", "Gérer les qualifications", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.QUALIFICATION_ADD,
//                "permission.basedata.qualification.add", "Ajouter des qualifications", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.QUALIFICATION_EDIT,
//                "permission.basedata.qualification.edit", "Modifier des qualifications", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.QUALIFICATION_DELETE,
//                "permission.basedata.qualification.delete", "Supprimer des qualifications", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.QUALIFICATION_LIST,
//                "permission.basedata.qualification.list", "Consulter la liste des qualifications", PERMISSION_CATEGORY_ID));
//        
//        //Religion
//        permissions.add(new Permission(BaseDataPermissions.RELIGION_MANAGE,
//                "permission.basedata.religion.manage", "Gérer les religions", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.RELIGION_ADD,
//                "permission.basedata.religion.add", "Ajouter des religions", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.RELIGION_EDIT,
//                "permission.basedata.religion.edit", "Modifier des religions", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.RELIGION_DELETE,
//                "permission.basedata.religion.delete", "Supprimer des religions", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.RELIGION_LIST,
//                "permission.basedata.religion.list", "Consulter la liste des religions", PERMISSION_CATEGORY_ID));
//        
//        //Title
//        permissions.add(new Permission(BaseDataPermissions.TITLE_MANAGE,
//                "permission.basedata.title.manage", "Gérer les titres", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.TITLE_ADD,
//                "permission.basedata.title.add", "Ajouter des titres", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.TITLE_EDIT,
//                "permission.basedata.title.edit", "Modifier des titres", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.TITLE_DELETE,
//                "permission.basedata.title.delete", "Supprimer des titres", PERMISSION_CATEGORY_ID));
//        permissions.add(new Permission(BaseDataPermissions.TITLE_LIST,
//                "permission.basedata.title.list", "Consulter la liste des titres", PERMISSION_CATEGORY_ID));
//                
        return permissions;
    }

    @Override
    public Collection<Role> roles() {
        return Collections.EMPTY_LIST;
    }

   
}
